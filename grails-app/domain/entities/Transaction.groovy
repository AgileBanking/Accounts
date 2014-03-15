package entities
import java.util.UUID

import org.codehaus.groovy.runtime.dgmimpl.NumberNumberPlus.LongInteger

class Transaction {  
    Account         account    
    Long            accRecNo = 0
    String          transCode                    //if exists in SpecialEvent.modelEvent.code else ModelEvent.code
    String          secondaryCode
    byte            dimension = 0
    String          currencyCode
    BigDecimal      amount
    BigDecimal      rate = 1.00
    BigDecimal      localAmount
    String          refDoc
    String          customerNotes
    String          notes
    String          systemNotes
    Date            postDate = new Date()
    Date            valueDate = new Date()
    Date            availabilityDate = new Date()
    Date            activationDate = null
    Date            deactivationDate = null    
    Long            transGroupID
    String          transUniqueID =  UUID.randomUUID().toString()
    byte            isSystemAccount = 0
    Long            userID                   // Person.id from Parties
    Long            postSeqNo                // User PostSeq 
    Long            approverId               // Person.id from Parties
    int             channel = 0              // channel.id from Commons
    Long            orgUnit = 0              // orgUnit.id from Commons
    Long            userId
    Date            dateCreated
    Date            lastUpdated
    
    static belongsTo = [account: Account]
    
    static constraints = {
        account             ()
        accRecNo            ()
        transCode           ()
        secondaryCode       (nullable:true)
        dimension           ()       
        currencyCode        ()
        amount              (scale:2)
        rate                (scale:5)
        localAmount         (scale:2, editable:false)
        refDoc              (nullable:true)
        customerNotes       (nullable:true, size:0..255, widget: 'textarea')
        notes               (nullable:true, size:0..250, widget: 'textarea')
        systemNotes         (nullable:true, size:0..255, widget: 'textarea')
        postDate            ()
        valueDate           (nullable:true)
        availabilityDate    (nullable:true)
        activationDate      (nullable:true)
        deactivationDate    (nullable:true)
        transGroupID        (nullable:true)
        transUniqueID       ()
        isSystemAccount     ()
        userID              ()
        postSeqNo           ()
        approverId          (nullable:true)
        channel             ()
        orgUnit             ()
        dateCreated() // implied => editable:false, bindable: false
        lastUpdated() // implied => editable:false, bindable: false
    }
}
