package onion.poc.external.services.spring

import onion.poc.external.services.spring.controller.FundsTransferServiceController
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

@SpringBootTest
class LoadContextTest extends Specification {

    @Autowired (required = false)
    private FundsTransferServiceController fundsTransferServiceController

    def "when context is loaded then all expected beans are created"() {
        expect: "the WebController is created"
        fundsTransferServiceController
    }
}
