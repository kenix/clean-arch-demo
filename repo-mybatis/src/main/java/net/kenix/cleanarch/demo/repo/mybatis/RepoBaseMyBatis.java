/*
* Created at 19:10 on 16.06.17
*/
package net.kenix.cleanarch.demo.repo.mybatis;

import java.util.function.Function;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 * @author zzhao
 */
@RequiredArgsConstructor
public abstract class RepoBaseMyBatis {

  private final SqlSessionFactory sqlSessionFactory;

  protected <T> T withSession(Function<SqlSession, T> func) {
    return withSession(SqlSessionFactory::openSession, func);
  }

  protected <T> T withSession(Function<SqlSessionFactory, SqlSession> sessionSupplier,
      Function<SqlSession, T> func) {
    try (final SqlSession sqlSession = sessionSupplier.apply(this.sqlSessionFactory)) {
      return func.apply(sqlSession);
    }
  }
}
