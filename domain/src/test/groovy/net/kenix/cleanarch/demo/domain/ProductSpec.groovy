package net.kenix.cleanarch.demo.domain

import spock.lang.Specification

/**
 * @author zzhao
 */
class ProductSpec extends Specification {

  def 'product access'() {
    when:
    def product = new Product()
    then:
    product

    when:
    product.id = 11L
    then:
    product.id == 11L

    when:
    product.name = 'foo'
    then:
    product.name == 'foo'

    when:
    product.producer = 'bar'
    then:
    product.producer == 'bar'
  }
}
