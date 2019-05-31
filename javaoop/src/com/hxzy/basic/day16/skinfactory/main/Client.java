package com.hxzy.basic.day16.skinfactory.main;

import com.hxzy.basic.day16.skinfactory.button.Button;
import com.hxzy.basic.day16.skinfactory.combobox.ComboBox;
import com.hxzy.basic.day16.skinfactory.factory.SkinFactory;
import com.hxzy.basic.day16.skinfactory.factory.SpringSkinFactory;
import com.hxzy.basic.day16.skinfactory.textfield.TextField;

/**
 * @author chenyongzhi
 * @date 2019/5/15 15:08
 */
public class Client {

    public static void main(String[] args) {

        SkinFactory factory = new SpringSkinFactory();
        Button button = factory.createButton();
        TextField textField = factory.createTextField();
        ComboBox comboBox = factory.createComboBox();

        button.display();
        textField.display();
        comboBox.display();

    }
}
