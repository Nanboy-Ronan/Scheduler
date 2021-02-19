package persistence;

import org.json.JSONObject;

// Reference: from JsonSerializationDemo
public interface Writable {
    // EFFECTS: returns this as JSON object
    JSONObject toJson();
}
