package com.example.test;

import com.example.test.model.Value;
import com.example.test.repository.ValueRepository;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.converter.StringToIntegerConverter;
import com.vaadin.flow.router.Route;

@Route("counter")
public class CounterView extends VerticalLayout {
    private Value value;

    public CounterView(ValueRepository valueRepository) {

        value = valueRepository.findById(1L).orElse(new Value());

        TextField textField = new TextField("Значение", value.getNumber().toString());
        Binder<Value> binder = new Binder<>(Value.class);
        binder.forField(textField).withConverter(new StringToIntegerConverter("Введите число")).bind(Value::getNumber, Value::setNumber);

        Button button = new Button("Увеличить");
        button.addClickListener(event -> {
            int currentValue = Integer.parseInt(textField.getValue());
            value.setNumber(currentValue + 1);
            valueRepository.save(value);
            textField.setValue(value.getNumber().toString());
        });

        add(textField, button);
    }
}