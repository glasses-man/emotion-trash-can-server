package com.emotion.trash.can.demo.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostSearchRequest extends PageRequest {

    private String title;

}
