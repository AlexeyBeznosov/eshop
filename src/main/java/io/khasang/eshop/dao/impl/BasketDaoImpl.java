package io.khasang.eshop.dao.impl;

import io.khasang.eshop.dao.BasketDao;
import io.khasang.eshop.entity.Basket;

import javax.persistence.Query;
import java.util.List;

public class BasketDaoImpl extends BasicDaoImpl<Basket> implements BasketDao {
    public BasketDaoImpl(Class<Basket> entityClass) {
        super(entityClass);
    }

    /**
     * Method of obtaining the user's product
     *
     * @param user whose basket we will receive
     * @return list of goods of the users
     */
    @Override
    public List<Basket> getGoodsByUser(String user) {
        Query query = getSession().createQuery("SELECT b FROM Basket as b WHERE b.user = :userName");
        query.setParameter("userName", user);
        return query.getResultList();
    }

    /**
     * Add new product
     * If the product is in the basket, update its quantity,
     * if not add new ones.
     *
     * @param product = new product
     * @return new product or update product
     */
    @Override
    public Basket add(Basket product) {
        List<Basket> basket = getGoodsByUser(product.getUser());
        for (Basket productInBasket : basket) {
            if (productInBasket.equals(product)) {
                productInBasket.setQuantity(productInBasket.getQuantity() + product.getQuantity());
                update(productInBasket);
                return productInBasket;
            }
        }
        getSession().save(product);
        return product;
    }

    /**
     * Method for delete goods in Basket by User name
     *
     * @param user = User name
     */
    public void clear(String user){
        List<Basket> basketList = getSession().createQuery("SELECT b FROM Basket b WHERE b.user= :userName")
                .setParameter("userName", user).list();
        for(Basket basket: basketList){
            if(basket.getUser().equals(user)){
                delete(basket);
            }
        }
//        getSession().createQuery("DELETE Basket b WHERE b.user = :userName")
//        .setParameter("userName", user);
    }
}
