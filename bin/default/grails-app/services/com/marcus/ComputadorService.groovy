package com.marcus

import grails.gorm.services.Service

@Service(Computador)
interface ComputadorService {

    Computador get(Serializable id)

    List<Computador> list(Map args)

    Long count()

    void delete(Serializable id)

    Computador save(Computador computador)

}