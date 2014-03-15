package entities

class Account {
    String              accNo
    String              name      
    AccountType         accType
    Long                masterProduct
    String              currencyIso2
    Long                productPolicy // περιλαμβάνει ή χρειάζεται να έχουμε και τη Version?
    Date                dateOpened = new Date()
    Date                lastMovement 
    Long                lastRecNo = 0
    int                 statementFreq = 0
    int                 passbookLastPageLine
    int                 passbookLastPrintedEvent
    AccountStatus       accStatus
    RiskLevel           riskLevel
    Account             interestAccount
    Account             feedingAccount
    String              balanceCalc = "C-D"
    BigDecimal          previousBalance = 0
    BigDecimal          ytdDebit = 0
    BigDecimal          ytdCredit = 0
    BigDecimal          available = 0
    BigDecimal          debitLimit = 0
    BigDecimal          maxExcessAllowed = 0
    BigDecimal          excess = 0
    BigDecimal          blocked = 0
    String              notes
    String              migratedAccNo
    StatementFrequency  statementFrequency
    StatementDelivery   statementDelivery
    String              recStatus
    Date                dateCreated //system timestamp
    Date                lastUpdated //system timestamp
    
    
    String toString() {"$accNo:$name"}
    
    static belongsTo = [accOwner:AccOwner]
    static hasMany = [transactions:Transaction, shadowAccounts:ShadowAccount]
    
    static mapping = {
        accNo index:'Acc_Idx'
    } 
    
    static constraints = {
        accNo           (unique:true, size:8..40)
        name            (blank:true, nulable:true, maxsize:40)
        accOwner        ()
        accStatus       ()
        accType         ()
        productPolicy   ()
        dateOpened      (editable:false, format:'yyyy-mm-dd', validator:{it<new Date()})
        lastMovement    (editable:false, format:'yyyy-mm-dd', validator:{it<new Date()})
//        lastRecNo       (editable:false)    // use the 'version'
        statementFreq   (inList:[0,1,2,3,4,6,12])
        balanceCalc     (editable:false, display:false, inList:["D-C","C-D"])
        previousBalance (editable:false, scale:2, format:'#,##0.00')
        ytdDebit        (editable:false, scale:2, format:'#,##0.00')
        ytdCredit       (editable:false, scale:2, format:'#,##0.00')
        blocked         (editable:false, scale:2, format:'#,##0.00')
        debitLimit      (editable:false, scale:2, format:'#,##0.00')
        shadowAccounts  (nullable:true)
        notes           (nullable:true, size:0..250, widget: 'textarea')
        migratedAccNo   (nullable:true)
        recStatus       (editable:false, display:false, inList:["Active", "Deleted"])
        dateCreated     (editable:false)
        lastUpdated     (editable:false)   
    }    
}
