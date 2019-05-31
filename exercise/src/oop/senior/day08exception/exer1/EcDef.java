package oop.senior.day08exception.exer1;

/**
 * @author chenyongzhi
 * @create 2019/5/23 20:45
 */
public class EcDef extends RuntimeException {

    static final long serialVersionUID = -33834993124229948L;

    public EcDef() {
    }

    public EcDef(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return "除数不能为负数！";
    }
}
