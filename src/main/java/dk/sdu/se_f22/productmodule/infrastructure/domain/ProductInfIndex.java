package dk.sdu.se_f22.productmodule.infrastructure.domain;

import dk.sdu.se_f22.SharedLibrary.models.Product;

import java.util.List;

public interface ProductInfIndex {

	void indexProducts(List<Product> products);

}
