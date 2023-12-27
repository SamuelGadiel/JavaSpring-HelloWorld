package br.com.samuel.helloworld.domain.products;

import br.com.zydon.commons.domain.Identifier;
import br.com.zydon.commons.domain.utils.IdUtils;


public class ProductID extends Identifier {

    public ProductID( final String value ) {
        super(value);
    }

    public static ProductID from( String anId ) {
        return new ProductID(anId.toLowerCase());
    }

    public static ProductID unique() {
        return ProductID.from(IdUtils.uuid());
    }

    @Override
    public String getValue() {
        return this.value;
    }
}
