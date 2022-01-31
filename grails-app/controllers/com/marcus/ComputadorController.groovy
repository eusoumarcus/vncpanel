package com.marcus

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class ComputadorController {

    ComputadorService computadorService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond computadorService.list(params), model:[computadorCount: computadorService.count()]
    }

    def show(Long id) {
        respond computadorService.get(id)
    }

    def create() {
        respond new Computador(params)
    }

    def save(Computador computador) {
        if (computador == null) {
            notFound()
            return
        }

        try {
            computadorService.save(computador)
        } catch (ValidationException e) {
            respond computador.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'computador.label', default: 'Computador'), computador.id])
                redirect computador
            }
            '*' { respond computador, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond computadorService.get(id)
    }

    def update(Computador computador) {
        if (computador == null) {
            notFound()
            return
        }

        try {
            computadorService.save(computador)
        } catch (ValidationException e) {
            respond computador.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'computador.label', default: 'Computador'), computador.id])
                redirect computador
            }
            '*'{ respond computador, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        computadorService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'computador.label', default: 'Computador'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'computador.label', default: 'Computador'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
