package nl.sogeti.petshop.model;

import java.io.Serializable;

/**
 *
 * @author geenenju
 */
public interface HasId<T> extends Serializable {

    T getId();

    void setId(T id);
}
