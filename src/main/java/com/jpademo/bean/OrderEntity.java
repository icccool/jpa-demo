package com.jpademo.bean;

import javax.persistence.*;

@Entity
@Table(name = "t_order")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;


    @Column(name = "orderNum")
    String orderNum;


    @Column(name = "user_id")
    String userId;


    @JoinColumn(name = "t_plan", referencedColumnName = "cg_code")
    int cgCode;

    @JoinColumn(name = "t_plan", referencedColumnName = "planCode")
    int planCode;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
