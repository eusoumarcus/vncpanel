package com.marcus

class Computador {
    String name
    String ipaddress
    String macaddress
    String hostname
    String description
    String location

    static hasMany = [impressoras: Impressora]

    static constraints = {
    }
}
