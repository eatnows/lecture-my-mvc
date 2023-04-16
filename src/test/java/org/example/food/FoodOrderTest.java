package org.example.food;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatCode;

public class FoodOrderTest {

    @DisplayName("주문을 생성할 수 있다.")
    @Test
    void createTest() {
        Customer customer = new Customer();
        Menu menu = new Menu(List.of(new MenuItem("돈까스", 5000), new MenuItem("냉면", 7000)));

        assertThatCode(() -> new FoodOrder(customer, "돈까스", menu))
                .doesNotThrowAnyException();
    }
}
