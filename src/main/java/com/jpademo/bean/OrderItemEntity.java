package com.jpademo.bean;

import javax.persistence.*;

@Entity
@Table(name = "t_order_item",indexes = {
        @Index(name = "PERSON_INDX_0", columnList = "age"),
        @Index(name = "PERSON_INDX_1", columnList = "order_id") }
       )
public class OrderItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;

    @Column(name = "order_id")
    int orderId;

    @Column
    int num;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
