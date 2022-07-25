package com.dailycoding.user.VO;

import com.dailycoding.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
 public class ResponseTemplateVO {

    private User user;
    private Department department;


}
