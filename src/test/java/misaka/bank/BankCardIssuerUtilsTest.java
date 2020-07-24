package misaka.bank;

import artoria.exchange.FastJsonProvider;
import artoria.exchange.JsonUtils;
import com.alibaba.fastjson.JSON;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Ignore
public class BankCardIssuerUtilsTest {
    private static Logger log = LoggerFactory.getLogger(BankCardIssuerUtilsTest.class);

    @Test
    public void test1() {
        JsonUtils.setJsonProvider(new FastJsonProvider());
        BankCardIssuerUtils.setBankCardIssuerProvider(new SupfreeNetBankCardIssuerProvider());
//        BankCardIssuerUtils.setBankCardIssuerProvider(new FileBasedBankCardIssuerProvider());
//        BankCardIssuerUtils.setBankCardIssuerProvider(new FileBasedBankCardIssuerProvider("bank_card_info.data"));
        BankCardIssuer bankCardIssuer = BankCardIssuerUtils.findByBankCardNumber("622600687501042806");
        log.info("{}", JSON.toJSONString(bankCardIssuer));
        BankCardIssuer bankCardIssuer1 = BankCardIssuerUtils.findByBankCardNumber("6230960288002899254");
        log.info("{}", JSON.toJSONString(bankCardIssuer1));
        BankCardIssuer bankCardIssuer2 = BankCardIssuerUtils.findByBankCardNumber("6217994000264606028");
        log.info("{}", JSON.toJSONString(bankCardIssuer2));
        BankCardIssuer bankCardIssuer3 = BankCardIssuerUtils.findByBankCardNumber("6230666046001759766");
        log.info("{}", JSON.toJSONString(bankCardIssuer3));
    }

}
