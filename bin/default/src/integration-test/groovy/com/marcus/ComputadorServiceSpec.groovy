package com.marcus

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class ComputadorServiceSpec extends Specification {

    ComputadorService computadorService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Computador(...).save(flush: true, failOnError: true)
        //new Computador(...).save(flush: true, failOnError: true)
        //Computador computador = new Computador(...).save(flush: true, failOnError: true)
        //new Computador(...).save(flush: true, failOnError: true)
        //new Computador(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //computador.id
    }

    void "test get"() {
        setupData()

        expect:
        computadorService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Computador> computadorList = computadorService.list(max: 2, offset: 2)

        then:
        computadorList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        computadorService.count() == 5
    }

    void "test delete"() {
        Long computadorId = setupData()

        expect:
        computadorService.count() == 5

        when:
        computadorService.delete(computadorId)
        sessionFactory.currentSession.flush()

        then:
        computadorService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Computador computador = new Computador()
        computadorService.save(computador)

        then:
        computador.id != null
    }
}
