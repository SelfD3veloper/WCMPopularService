package utils;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * --------------------------------------------------------
 * Created by Carlos Bedoy on 3/08/14.
 * CBYoutubeApi
 * Mobile Developer
 * Aguascalientes Mexico
 * Email:       carlos.bedoy@gmail.com
 * Facebook:    https://www.facebook.com/carlos.bedoy
 * ---------CODE && MUSIC ----------------------------------
 */
public class NotificationCenter
{
    private HashMap<Integer, ArrayList<Object>> observers;
    private HashMap<String,  Object> memCache;
    private HashMap<Integer, Object> removeAfterBroadcast;
    private HashMap<Integer, Object> addAfterBroadcast;
    private boolean broadcasting;

    public NotificationCenter()
    {
        this.observers              = new HashMap<Integer, ArrayList<Object>>();
        this.memCache               = new HashMap<String, Object>();
        this.removeAfterBroadcast   = new HashMap<Integer, Object>();
        this.addAfterBroadcast      = new HashMap<Integer, Object>();
        this.broadcasting           = false;
    }

    public void addToMemCache(int id, Object object)
    {
        addToMemCache(String.valueOf(id), object);
    }

    public void addToMemCache(String id, Object object)
    {
        memCache.put(id, object);
    }

    public Object getFromMemCache(int id)
    {
        return getFromMemCache(String.valueOf(id), null);
    }

    public Object getFromMemCache(String id, Object defaultValue)
    {
        Object obj = memCache.get(id);
        if (obj != null) {
            memCache.remove(id);
            return obj;
        }
        return defaultValue;
    }

    public void postNotificationName(int id, Object... args)
    {
        if(observers == null)
            return;
        synchronized (observers)
        {
            broadcasting = true;
            ArrayList<Object> objects = observers.get(id);
            if (objects != null)
            {
                for (Object obj : objects)
                    ((INotificationDelegate)obj).didReceivedNotification(id, args);
            }
            broadcasting = false;
            if (!removeAfterBroadcast.isEmpty())
            {
                for (HashMap.Entry<Integer, Object> entry : removeAfterBroadcast.entrySet())
                    removeObserver(entry.getValue(), entry.getKey());
                removeAfterBroadcast.clear();
            }
            if (!addAfterBroadcast.isEmpty())
            {
                for (HashMap.Entry<Integer, Object> entry : addAfterBroadcast.entrySet())
                    addObserver(entry.getValue(), entry.getKey());
                addAfterBroadcast.clear();
            }
        }
    }

    public void addObserver(Object observer, int id)
    {
        synchronized (observers)
        {
            if (broadcasting)
            {
                addAfterBroadcast.put(id, observer);
                return;
            }
            ArrayList<Object> objects = observers.get(id);
            if (objects == null)
            {
                observers.put(id, (objects = new ArrayList<Object>()));
            }
            if (objects.contains(observer))
            {
                return;
            }
            objects.add(observer);
        }
    }

    public void removeObserver(Object observer, int id)
    {
        synchronized (observers)
        {
            if (broadcasting)
            {
                removeAfterBroadcast.put(id, observer);
                return;
            }
            ArrayList<Object> objects = observers.get(id);
            if (objects != null)
            {
                objects.remove(observer);
                if (objects.size() == 0)
                {
                    observers.remove(id);
                }
            }
        }
    }

}
