namespace java com.jump.account.base.thrift
service AccountService{
    bool saveAccount(1:binary request)
    binary getAccountByKeyword(1:string keyword)
    void update(1:binary request)
    bool removeAccountByKeyword(1:string keyword)
    binary getPasswordAndUserNameByKeyword(1:string keyword)
}
