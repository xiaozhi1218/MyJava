package com.hxzy.basic.day16.skinfactory.factory;

import com.hxzy.basic.day16.skinfactory.button.Button;
import com.hxzy.basic.day16.skinfactory.button.SummerButton;
import com.hxzy.basic.day16.skinfactory.combobox.ComboBox;
import com.hxzy.basic.day16.skinfactory.combobox.SummerComboBox;
import com.hxzy.basic.day16.skinfactory.textfield.SummerTextField;
import com.hxzy.basic.day16.skinfactory.textfield.TextField;

/**
 * @author chenyongzhi
 * @date 2019/5/15 15:05
 */
public class SummerSkinFactory extends SkinFactory {
    @Override
    public Button createButton() {
        return new SummerButton();
    }

    @Override
    public TextField createTextField() {
        return new SummerTextField();
    }

    @Override
    public ComboBox createComboBox() {
        return new SummerComboBox();
    }
}
