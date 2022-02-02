package com.marcus

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class ImpressoraController {

    ImpressoraService impressoraService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond impressoraService.list(params), model:[impressoraCount: impressoraService.count()]
    }

    def show(Long id) {
        respond impressoraService.get(id)
    }

    def create() {
        respond new Impressora(params)
    }

    def save(Impressora impressora) {
        if (impressora == null) {
            notFound()
            return
        }

        try {
            impressoraService.save(impressora)
        } catch (ValidationException e) {
            respond impressora.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'impressora.label', default: 'Impressora'), impressora.id])
                redirect impressora
            }
            '*' { respond impressora, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond impressoraService.get(id)
    }

    def update(Impressora impressora) {
        if (impressora == null) {
            notFound()
            return
        }

        try {
            impressoraService.save(impressora)
        } catch (ValidationException e) {
            respond impressora.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'impressora.label', default: 'Impressora'), impressora.id])
                redirect impressora
            }
            '*'{ respond impressora, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        impressoraService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'impressora.label', default: 'Impressora'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'impressora.label', default: 'Impressora'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
