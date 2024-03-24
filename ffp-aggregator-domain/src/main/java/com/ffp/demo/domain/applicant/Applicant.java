package com.ffp.demo.domain.applicant;

import com.alibaba.cola.domain.Entity;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

@Data
@Entity
public class Applicant  implements Serializable {
    private String address;
    private String applicantName;
    private String facilityType;
    private String foodItems;
    private String daysHours;

    public List<String> getFoods() {
        //the fooditems are joined with : or ;  split them  to array
        String[] foodArray = this.foodItems.split("[:|;]");
        List<String> foodList = new ArrayList<>(foodArray.length);
        Collections.addAll(foodList, foodArray);
        //return the list with trimed item
        return foodList.stream().map(StringUtils::trim).toList();
    }
}