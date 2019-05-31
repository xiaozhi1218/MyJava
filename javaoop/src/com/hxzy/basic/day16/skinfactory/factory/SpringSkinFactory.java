package com.hxzy.basic.day16.skinfactory.factory;

import com.hxzy.basic.day16.skinfactory.button.Button;
import com.hxzy.basic.day16.skinfactory.button.SpringButton;
import com.hxzy.basic.day16.skinfactory.combobox.ComboBox;
import com.hxzy.basic.day16.skinfactory.combobox.SpringComboBox;
import com.hxzy.basic.day16.skinfactory.textfield.SpringTextField;
import com.hxzy.basic.day16.skinfactory.textfield.TextField;

/**
 * @author chenyongzhi
 * @date 2019/5/15 15:04
 */
public class SpringSkinFactory extends SkinFactory {
    @Override
    public Button createButton() {
        return new SpringButton();
    }

    @Override
    public TextField createTextField() {
        return new SpringTextField();
    }

    @Override
    public ComboBox createComboBox() {
        return new SpringComboBox();
    }
}
