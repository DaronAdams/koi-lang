package interpreter;

import java.util.List;

interface KoiCallable {
    int arity();
    Object call(Interpreter interpreter, List<Object> arguments);
}
