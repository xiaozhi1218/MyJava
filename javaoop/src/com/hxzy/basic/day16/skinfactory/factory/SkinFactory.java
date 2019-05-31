package com.hxzy.basic.day16.skinfactory.factory;

import com.hxzy.basic.day16.skinfactory.button.Button;
import com.hxzy.basic.day16.skinfactory.combobox.ComboBox;
import com.hxzy.basic.day16.skinfactory.textfield.TextField;

/**
 * @author chenyongzhi
 * @date 2019/5/15 15:02
 */
public abstract class SkinFactory {

    public abstract Button createButton();

    public abstract TextField createTextField();

    public abstract ComboBox createComboBox();
}
