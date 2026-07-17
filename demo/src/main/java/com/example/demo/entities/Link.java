package com.example.demo.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class Link {
    private @Getter @Setter Integer id;
    private @Getter @Setter String long_form;
    private @Getter @Setter String short_form;
    private @Getter @Setter String prefix;
    private @Getter @Setter String duration;

    
}
