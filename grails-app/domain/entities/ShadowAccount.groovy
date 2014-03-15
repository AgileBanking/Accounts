package entities

class ShadowAccount {  
    Account             account
    int                 dimension = 1
    BigDecimal          previousBalance = 0
    BigDecimal          ytdDebit = 0
    BigDecimal          ytdCredit = 0
    BigDecimal          available = 0
    BigDecimal          blocked = 0
    String              recStatus = "Active"
    Date                dateCreated
    Date                lastUpdated
    
    String toString() {"$account:$dimension"}

    static mapping = {
        masterAccount   index:'ShadowAcc_Idx'
        dimension       index:'ShadowAcc_Idx'
    }
    
    static belongsTo = [account: Account]
    
    static constraints = {
        account         ()  
        dimension       (min:1)  
        previousBalance (scale:2, format:'#,##0.00')
        ytdDebit        (scale:2, format:'#,##0.00')
        ytdCredit       (scale:2, format:'#,##0.00')
        available       (scale:2, format:'#,##0.00')
        blocked         (scale:2, format:'#,##0.00')
        recStatus(editable:false, display:false, inList:["Active", "Deleted"])
        dateCreated     (editable:false, bindable: false)
        lastUpdated     (editable:false, bindable: false)
    }
}
