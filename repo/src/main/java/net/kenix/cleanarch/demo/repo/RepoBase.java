/*
* Created at 18:23 on 16.06.17
*/
package net.kenix.cleanarch.demo.repo;

/**
 * @author zzhao
 */
public interface RepoBase<ID, OBJ> {

  OBJ findById(ID id);
}
