package jpabook.jpashop.controller;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class BookForm {

    private Long id;

    @NotEmpty(message = "상품 이름은 필수입니다.")
    private String name;

    @Min(message = "가격은 숫자가 되어야 하고 0이상이어야 합니다.", value = 0L)
    private int price;

    @Min(message = "재고수량은 숫자가 되어야 하고 0이상이어야 합니다.", value = 0L)
    private int stockQuantity;

    private String author;
    private String isbn;
}
