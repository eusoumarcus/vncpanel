package com.marcus

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class ImpressoraServiceSpec extends Specification {

    ImpressoraService impressoraService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Impressora(...).save(flush: true, failOnError: true)
        //new Impressora(...).save(flush: true, failOnError: true)
        //Impressora impressora = new Impressora(...).save(flush: true, failOnError: true)
        //new Impressora(...).save(flush: true, failOnError: true)
        //new Impressora(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //impressora.id
    }

    void "test get"() {
        setupData()

        expect:
        impressoraService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Impressora> impressoraList = impressoraService.list(max: 2, offset: 2)

        then:
        impressoraList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        impressoraService.count() == 5
    }

    void "test delete"() {
        Long impressoraId = setupData()

        expect:
        impressoraService.count() == 5

        when:
        impressoraService.delete(impressoraId)
        sessionFactory.currentSession.flush()

        then:
        impressoraService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Impressora impressora = new Impressora()
        impressoraService.save(impressora)

        then:
        impressora.id != null
    }
}
