package com.intkgc.curve.registry;

import com.badlogic.gdx.Gdx;
import org.reflections.Reflections;

import java.util.ArrayList;
import java.util.Set;

/**
 * {@code Registry} class for simplified registration of different types of objects.
 *
 * @author Kirbo
 * @version 2.0
 */

public class Registry<I extends RegistryObject> {
    /**
     * Array of objects
     */
    private final ArrayList<I> objects = new ArrayList<>();
    /**
     * Registry group id
     */
    private final String groupID;


    /**
     * @param groupID group id ({@link IDManager#newGroup(String)})
     */
    public Registry(String groupID) {
        this.groupID = groupID;
        IDManager.newGroup(groupID);
    }


    /**
     * A method for those who are too lazy to specify the id in the registration method.
     * Object must have {@linkplain RegistryMetadata this} annotation
     *
     * @param object object 🗿
     */
    public void register(I object) {
        if (!object.getClass().isAnnotationPresent(RegistryMetadata.class))
            throw new IllegalStateException("Object must have annotation");
        RegistryMetadata annotation = object.getClass().getAnnotation(RegistryMetadata.class);
        register(object, annotation.value());
    }

    /**
     * Registers an object
     *
     * @param object object 🗿
     * @param id     object string-id
     */
    public void register(I object, String id) {
        object.setId(IDManager.newID(groupID + ":" + id));
        object.setStringId(id);
        object.init();
        objects.add(object);
        Gdx.app.log("Registry", "registered " + groupID + ", with id \"" + object.getStringId() + "\", integer id " + object.id);

    }

    /**
     * Registers all objects with an {@linkplain RegistryMetadata annotation} from the package.
     * <p>
     * It works but doesn't work
     *
     * @param package_ java-package
     */
    @SuppressWarnings("unchecked")
    public void registerFromPackage(String package_) {
        Reflections reflections = new Reflections(package_);
        Set<Class<? extends RegistryObject>> classes = reflections.getSubTypesOf(RegistryObject.class);
        for (Class<? extends RegistryObject> object : classes) {
            if (object.isAnnotationPresent(RegistryMetadata.class)) {
                try {
                    register((I) object.getDeclaredConstructor().newInstance());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * @param id integer-id
     * @return true if it has an object, false if it doesn't
     */
    public boolean has(int id) {
        for (I object : objects) {
            if (object.id == id) return true;
        }
        return false;
    }

    /**
     * @param id integer-id
     * @return object by id
     */
    public I get(int id) {
        return objects.get(id);
    }

    /**
     * WHY?
     *
     * @return ArrayList with all objects (lol)
     */
    public ArrayList<I> getObjects() {
        return objects;
    }
}
