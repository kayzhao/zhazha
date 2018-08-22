package cn.kay.zhazha.repositories;

import cn.kay.zhazha.domain.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer>{
}
