package org.example.digitallibrarymanagementsystem.repository;

import org.example.digitallibrarymanagementsystem.model.Profile;
import org.example.digitallibrarymanagementsystem.util.HibernateUtil;
import org.glassfish.jaxb.core.v2.model.core.ID;

import java.util.Optional;

public class ProfileRepository implements GenericRepository<Profile, ID> {
    @Override
    public Profile save(Profile profile) {
        HibernateUtil.inTxReturn(entityManager -> {
            entityManager.persist(profile);
            return profile;
        });
        return null;
    }

    @Override
    public Optional<Profile> findById(Profile profile, ID id) {
        return Optional.ofNullable(HibernateUtil.inTxReturn(entityManager ->
                entityManager.find(Profile.class,id)));
    }

    @Override
    public void update(Profile profile, ID id) {
        HibernateUtil.inTxReturn(entityManager -> {
            Profile profile1=entityManager.find(Profile.class,id);
            if (profile1==null){
                return null;
            }
            profile1.setBio(profile.getBio());
            profile1.setWebsite(profile.getWebsite());
            profile1.setAuthor(profile.getAuthor());

            return profile1;
        });
    }

    @Override
    public void delete(ID id) {
        HibernateUtil.inTxReturn(entityManager -> {
            Profile profile=entityManager.find(Profile.class,id);
            if (profile==null){
                System.out.println("Profile Not Found");
            }
            entityManager.remove(profile);
            return null;
        });
    }
}
