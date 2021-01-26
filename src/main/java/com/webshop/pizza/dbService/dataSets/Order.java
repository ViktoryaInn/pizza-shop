package com.webshop.pizza.dbService.dataSets;
;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

//@Entity
//@Table(name = "order")
public class Order {
//    @Id
//    @Column(name = "id", nullable = false, updatable = false)
    private int id;

    private String clientName;
    private String clientPhone;
    private float cost;
    private Date date;

    public Order(){
    }

    public Order(int id, String clientName, String clientPhone, float cost, Date date){
        this.id = id;
        this.clientName = clientName;
        this.clientPhone = clientPhone;
        this.cost = cost;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public String getClientName() {
        return clientName;
    }

    public String getClientPhone() { return clientPhone; }

    public float getCost() {
        return cost;
    }

    public Date getDate() {return date;}

    public void setClientName(String clientName){
        this.clientName = clientName;
    }

    public void setClientPhone(String clientPhone) { this.clientPhone = clientPhone; }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
