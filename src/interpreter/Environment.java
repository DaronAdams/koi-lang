package interpreter;

import java.util.Map;
import java.util.HashMap;

public class Environment {
    final Environment enclosing;
    private final Map<String, Object> values = new HashMap<>();


    Environment() {
        enclosing = null;
    }

    Environment(Environment enclosing) {
        this.enclosing = enclosing;
    }

    void define(String name, Object value) {
        values.put(name, value);
    }

    Object get(Token name) {
        if (values.containsKey(name.lexeme)) {
            return values.get(name.lexeme);
        }

        // Check outer environments for variable
        if (enclosing != null) {
            return enclosing.get(name);
        }

        throw new RuntimeError(name,
                "Undefined variable '" + name + "'.");
    }

    void assign(Token name, Object value) {
        if (values.containsKey(name.lexeme)) {
            values.put(name.lexeme, value);
            return;
        }

        // Check outer environments for variable
        if (enclosing != null) {
            enclosing.assign(name, value);
            return;
        }

        throw new RuntimeError(name,
                "Undefined variable '" + name.lexeme + "'.");
    }


}
