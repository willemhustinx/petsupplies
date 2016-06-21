package nl.sogeti.petshop.service;

import javax.ejb.Stateless;

import nl.sogeti.petshop.model.Account;

@Stateless
public class AccountService extends AbstractCrudRepository<Account> {

    @Override
    protected Class<Account> getEntityClass() {
        return Account.class;
    }

    public void create(Account account) {

        if (account != null && !accountExists(account)) {
            entityManager.persist(account);
        }
    }

    public Account find(Account account) {
        return entityManager.find(Account.class, account);
    }

    public Account find(String email) {
        return entityManager.find(Account.class, email);
    }

    public boolean accountExists(Account account) {
        return entityManager.createQuery("Select e From Account e Where EMAIL = '" + account.getEmail() + "'")
                .getResultList().size() == 1;
    }

}
