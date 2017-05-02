package com.fernando.proyectofinal.controller;

import com.fernando.proyectofinal.model.Member;

/**
 * Created by Dell on 01/05/2017.
 */

public class MemberController {
    String name;
    Member member;

    public MemberController(Member member) {
        this.member = member;
    }
}
