package dev.vepo.mystatistic.views;

import org.bson.types.ObjectId;

import io.quarkus.mongodb.panache.PanacheMongoEntity;
import io.quarkus.mongodb.panache.common.MongoEntity;

@MongoEntity(collection = "View")
public class View extends PanacheMongoEntity {
    public ObjectId id; // used by MongoDB for the _id field
    public String domain;
    public String idUser;
    public String path;
    public long time;

    public static View findByDomainAndUserAndPath(String domain, String idUser, String path){
        return find("domain = ?1 AND idUser = ?2 AND path = ?1", domain, idUser, path).firstResult();
    }
}
