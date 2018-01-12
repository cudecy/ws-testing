
package main.AcctinqResp;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="BalInqRs">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;choice maxOccurs="unbounded" minOccurs="0">
 *                   &lt;element name="AcctId">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="AcctId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="AcctType">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="SchmCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                       &lt;element name="SchmType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                     &lt;/sequence>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                             &lt;element name="AcctCurr" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="BankInfo">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="BankId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                       &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                       &lt;element name="BranchId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                       &lt;element name="BranchName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                       &lt;element name="PostAddr">
 *                                         &lt;complexType>
 *                                           &lt;complexContent>
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                               &lt;sequence>
 *                                                 &lt;element name="Addr1" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                 &lt;element name="Addr2" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                 &lt;element name="Addr3" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                 &lt;element name="City" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                 &lt;element name="StateProv" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                 &lt;element name="PostalCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                 &lt;element name="Country" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                 &lt;element name="AddrType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                               &lt;/sequence>
 *                                             &lt;/restriction>
 *                                           &lt;/complexContent>
 *                                         &lt;/complexType>
 *                                       &lt;/element>
 *                                     &lt;/sequence>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="AcctBal">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="BalType">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                   &lt;enumeration value="CLRBAL"/>
 *                                   &lt;enumeration value="SANLIM"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                             &lt;element name="BalAmt">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="amountValue">
 *                                         &lt;simpleType>
 *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                             &lt;enumeration value="407.85"/>
 *                                             &lt;enumeration value="0.00"/>
 *                                           &lt;/restriction>
 *                                         &lt;/simpleType>
 *                                       &lt;/element>
 *                                       &lt;element name="currencyCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                     &lt;/sequence>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/choice>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="BalInq_CustomData" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "balInqRs",
    "balInqCustomData"
})
@XmlRootElement(name = "BalInqResponse")
public class BalInqResponse {

    @XmlElement(name = "BalInqRs", required = true)
    protected BalInqResponse.BalInqRs balInqRs;
    @XmlElement(name = "BalInq_CustomData", required = true)
    protected String balInqCustomData;

    /**
     * Gets the value of the balInqRs property.
     * 
     * @return
     *     possible object is
     *     {@link BalInqResponse.BalInqRs }
     *     
     */
    public BalInqResponse.BalInqRs getBalInqRs() {
        return balInqRs;
    }

    /**
     * Sets the value of the balInqRs property.
     * 
     * @param value
     *     allowed object is
     *     {@link BalInqResponse.BalInqRs }
     *     
     */
    public void setBalInqRs(BalInqResponse.BalInqRs value) {
        this.balInqRs = value;
    }

    /**
     * Gets the value of the balInqCustomData property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBalInqCustomData() {
        return balInqCustomData;
    }

    /**
     * Sets the value of the balInqCustomData property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBalInqCustomData(String value) {
        this.balInqCustomData = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;choice maxOccurs="unbounded" minOccurs="0">
     *         &lt;element name="AcctId">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="AcctId" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="AcctType">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="SchmCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                             &lt;element name="SchmType" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                           &lt;/sequence>
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                   &lt;element name="AcctCurr" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="BankInfo">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="BankId" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                             &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                             &lt;element name="BranchId" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                             &lt;element name="BranchName" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                             &lt;element name="PostAddr">
     *                               &lt;complexType>
     *                                 &lt;complexContent>
     *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                     &lt;sequence>
     *                                       &lt;element name="Addr1" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                                       &lt;element name="Addr2" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                                       &lt;element name="Addr3" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                                       &lt;element name="City" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                                       &lt;element name="StateProv" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                                       &lt;element name="PostalCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                                       &lt;element name="Country" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                                       &lt;element name="AddrType" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                                     &lt;/sequence>
     *                                   &lt;/restriction>
     *                                 &lt;/complexContent>
     *                               &lt;/complexType>
     *                             &lt;/element>
     *                           &lt;/sequence>
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="AcctBal">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="BalType">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                         &lt;enumeration value="CLRBAL"/>
     *                         &lt;enumeration value="SANLIM"/>
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                   &lt;element name="BalAmt">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="amountValue">
     *                               &lt;simpleType>
     *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                                   &lt;enumeration value="407.85"/>
     *                                   &lt;enumeration value="0.00"/>
     *                                 &lt;/restriction>
     *                               &lt;/simpleType>
     *                             &lt;/element>
     *                             &lt;element name="currencyCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                           &lt;/sequence>
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/choice>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "acctIdOrAcctBal"
    })
    public static class BalInqRs {

        @XmlElements({
            @XmlElement(name = "AcctId", type = BalInqResponse.BalInqRs.AcctId.class),
            @XmlElement(name = "AcctBal", type = BalInqResponse.BalInqRs.AcctBal.class)
        })
        protected List<Object> acctIdOrAcctBal;

        /**
         * Gets the value of the acctIdOrAcctBal property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the acctIdOrAcctBal property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getAcctIdOrAcctBal().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link BalInqResponse.BalInqRs.AcctId }
         * {@link BalInqResponse.BalInqRs.AcctBal }
         * 
         * 
         */
        public List<Object> getAcctIdOrAcctBal() {
            if (acctIdOrAcctBal == null) {
                acctIdOrAcctBal = new ArrayList<Object>();
            }
            return this.acctIdOrAcctBal;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="BalType">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *               &lt;enumeration value="CLRBAL"/>
         *               &lt;enumeration value="SANLIM"/>
         *             &lt;/restriction>
         *           &lt;/simpleType>
         *         &lt;/element>
         *         &lt;element name="BalAmt">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="amountValue">
         *                     &lt;simpleType>
         *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *                         &lt;enumeration value="407.85"/>
         *                         &lt;enumeration value="0.00"/>
         *                       &lt;/restriction>
         *                     &lt;/simpleType>
         *                   &lt;/element>
         *                   &lt;element name="currencyCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                 &lt;/sequence>
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "balType",
            "balAmt"
        })
        public static class AcctBal {

            @XmlElement(name = "BalType", required = true)
            protected String balType;
            @XmlElement(name = "BalAmt", required = true)
            protected BalInqResponse.BalInqRs.AcctBal.BalAmt balAmt;

            /**
             * Gets the value of the balType property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getBalType() {
                return balType;
            }

            /**
             * Sets the value of the balType property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setBalType(String value) {
                this.balType = value;
            }

            /**
             * Gets the value of the balAmt property.
             * 
             * @return
             *     possible object is
             *     {@link BalInqResponse.BalInqRs.AcctBal.BalAmt }
             *     
             */
            public BalInqResponse.BalInqRs.AcctBal.BalAmt getBalAmt() {
                return balAmt;
            }

            /**
             * Sets the value of the balAmt property.
             * 
             * @param value
             *     allowed object is
             *     {@link BalInqResponse.BalInqRs.AcctBal.BalAmt }
             *     
             */
            public void setBalAmt(BalInqResponse.BalInqRs.AcctBal.BalAmt value) {
                this.balAmt = value;
            }


            /**
             * <p>Java class for anonymous complex type.
             * 
             * <p>The following schema fragment specifies the expected content contained within this class.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;complexContent>
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *       &lt;sequence>
             *         &lt;element name="amountValue">
             *           &lt;simpleType>
             *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
             *               &lt;enumeration value="407.85"/>
             *               &lt;enumeration value="0.00"/>
             *             &lt;/restriction>
             *           &lt;/simpleType>
             *         &lt;/element>
             *         &lt;element name="currencyCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *       &lt;/sequence>
             *     &lt;/restriction>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "amountValue",
                "currencyCode"
            })
            public static class BalAmt {

                @XmlElement(required = true)
                protected String amountValue;
                @XmlElement(required = true)
                protected String currencyCode;

                /**
                 * Gets the value of the amountValue property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getAmountValue() {
                    return amountValue;
                }

                /**
                 * Sets the value of the amountValue property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setAmountValue(String value) {
                    this.amountValue = value;
                }

                /**
                 * Gets the value of the currencyCode property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getCurrencyCode() {
                    return currencyCode;
                }

                /**
                 * Sets the value of the currencyCode property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setCurrencyCode(String value) {
                    this.currencyCode = value;
                }

            }

        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="AcctId" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="AcctType">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="SchmCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                   &lt;element name="SchmType" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                 &lt;/sequence>
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *         &lt;element name="AcctCurr" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="BankInfo">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="BankId" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                   &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                   &lt;element name="BranchId" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                   &lt;element name="BranchName" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                   &lt;element name="PostAddr">
         *                     &lt;complexType>
         *                       &lt;complexContent>
         *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                           &lt;sequence>
         *                             &lt;element name="Addr1" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                             &lt;element name="Addr2" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                             &lt;element name="Addr3" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                             &lt;element name="City" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                             &lt;element name="StateProv" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                             &lt;element name="PostalCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                             &lt;element name="Country" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                             &lt;element name="AddrType" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                           &lt;/sequence>
         *                         &lt;/restriction>
         *                       &lt;/complexContent>
         *                     &lt;/complexType>
         *                   &lt;/element>
         *                 &lt;/sequence>
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "acctId",
            "acctType",
            "acctCurr",
            "bankInfo"
        })
        public static class AcctId {

            @XmlElement(name = "AcctId", required = true)
            protected String acctId;
            @XmlElement(name = "AcctType", required = true)
            protected BalInqResponse.BalInqRs.AcctId.AcctType acctType;
            @XmlElement(name = "AcctCurr", required = true)
            protected String acctCurr;
            @XmlElement(name = "BankInfo", required = true)
            protected BalInqResponse.BalInqRs.AcctId.BankInfo bankInfo;

            /**
             * Gets the value of the acctId property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getAcctId() {
                return acctId;
            }

            /**
             * Sets the value of the acctId property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setAcctId(String value) {
                this.acctId = value;
            }

            /**
             * Gets the value of the acctType property.
             * 
             * @return
             *     possible object is
             *     {@link BalInqResponse.BalInqRs.AcctId.AcctType }
             *     
             */
            public BalInqResponse.BalInqRs.AcctId.AcctType getAcctType() {
                return acctType;
            }

            /**
             * Sets the value of the acctType property.
             * 
             * @param value
             *     allowed object is
             *     {@link BalInqResponse.BalInqRs.AcctId.AcctType }
             *     
             */
            public void setAcctType(BalInqResponse.BalInqRs.AcctId.AcctType value) {
                this.acctType = value;
            }

            /**
             * Gets the value of the acctCurr property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getAcctCurr() {
                return acctCurr;
            }

            /**
             * Sets the value of the acctCurr property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setAcctCurr(String value) {
                this.acctCurr = value;
            }

            /**
             * Gets the value of the bankInfo property.
             * 
             * @return
             *     possible object is
             *     {@link BalInqResponse.BalInqRs.AcctId.BankInfo }
             *     
             */
            public BalInqResponse.BalInqRs.AcctId.BankInfo getBankInfo() {
                return bankInfo;
            }

            /**
             * Sets the value of the bankInfo property.
             * 
             * @param value
             *     allowed object is
             *     {@link BalInqResponse.BalInqRs.AcctId.BankInfo }
             *     
             */
            public void setBankInfo(BalInqResponse.BalInqRs.AcctId.BankInfo value) {
                this.bankInfo = value;
            }


            /**
             * <p>Java class for anonymous complex type.
             * 
             * <p>The following schema fragment specifies the expected content contained within this class.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;complexContent>
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *       &lt;sequence>
             *         &lt;element name="SchmCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *         &lt;element name="SchmType" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *       &lt;/sequence>
             *     &lt;/restriction>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "schmCode",
                "schmType"
            })
            public static class AcctType {

                @XmlElement(name = "SchmCode", required = true)
                protected String schmCode;
                @XmlElement(name = "SchmType", required = true)
                protected String schmType;

                /**
                 * Gets the value of the schmCode property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getSchmCode() {
                    return schmCode;
                }

                /**
                 * Sets the value of the schmCode property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setSchmCode(String value) {
                    this.schmCode = value;
                }

                /**
                 * Gets the value of the schmType property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getSchmType() {
                    return schmType;
                }

                /**
                 * Sets the value of the schmType property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setSchmType(String value) {
                    this.schmType = value;
                }

            }


            /**
             * <p>Java class for anonymous complex type.
             * 
             * <p>The following schema fragment specifies the expected content contained within this class.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;complexContent>
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *       &lt;sequence>
             *         &lt;element name="BankId" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *         &lt;element name="BranchId" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *         &lt;element name="BranchName" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *         &lt;element name="PostAddr">
             *           &lt;complexType>
             *             &lt;complexContent>
             *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                 &lt;sequence>
             *                   &lt;element name="Addr1" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *                   &lt;element name="Addr2" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *                   &lt;element name="Addr3" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *                   &lt;element name="City" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *                   &lt;element name="StateProv" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *                   &lt;element name="PostalCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *                   &lt;element name="Country" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *                   &lt;element name="AddrType" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *                 &lt;/sequence>
             *               &lt;/restriction>
             *             &lt;/complexContent>
             *           &lt;/complexType>
             *         &lt;/element>
             *       &lt;/sequence>
             *     &lt;/restriction>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "bankId",
                "name",
                "branchId",
                "branchName",
                "postAddr"
            })
            public static class BankInfo {

                @XmlElement(name = "BankId", required = true)
                protected String bankId;
                @XmlElement(name = "Name", required = true)
                protected String name;
                @XmlElement(name = "BranchId", required = true)
                protected String branchId;
                @XmlElement(name = "BranchName", required = true)
                protected String branchName;
                @XmlElement(name = "PostAddr", required = true)
                protected BalInqResponse.BalInqRs.AcctId.BankInfo.PostAddr postAddr;

                /**
                 * Gets the value of the bankId property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getBankId() {
                    return bankId;
                }

                /**
                 * Sets the value of the bankId property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setBankId(String value) {
                    this.bankId = value;
                }

                /**
                 * Gets the value of the name property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getName() {
                    return name;
                }

                /**
                 * Sets the value of the name property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setName(String value) {
                    this.name = value;
                }

                /**
                 * Gets the value of the branchId property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getBranchId() {
                    return branchId;
                }

                /**
                 * Sets the value of the branchId property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setBranchId(String value) {
                    this.branchId = value;
                }

                /**
                 * Gets the value of the branchName property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getBranchName() {
                    return branchName;
                }

                /**
                 * Sets the value of the branchName property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setBranchName(String value) {
                    this.branchName = value;
                }

                /**
                 * Gets the value of the postAddr property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BalInqResponse.BalInqRs.AcctId.BankInfo.PostAddr }
                 *     
                 */
                public BalInqResponse.BalInqRs.AcctId.BankInfo.PostAddr getPostAddr() {
                    return postAddr;
                }

                /**
                 * Sets the value of the postAddr property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BalInqResponse.BalInqRs.AcctId.BankInfo.PostAddr }
                 *     
                 */
                public void setPostAddr(BalInqResponse.BalInqRs.AcctId.BankInfo.PostAddr value) {
                    this.postAddr = value;
                }


                /**
                 * <p>Java class for anonymous complex type.
                 * 
                 * <p>The following schema fragment specifies the expected content contained within this class.
                 * 
                 * <pre>
                 * &lt;complexType>
                 *   &lt;complexContent>
                 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                 *       &lt;sequence>
                 *         &lt;element name="Addr1" type="{http://www.w3.org/2001/XMLSchema}string"/>
                 *         &lt;element name="Addr2" type="{http://www.w3.org/2001/XMLSchema}string"/>
                 *         &lt;element name="Addr3" type="{http://www.w3.org/2001/XMLSchema}string"/>
                 *         &lt;element name="City" type="{http://www.w3.org/2001/XMLSchema}string"/>
                 *         &lt;element name="StateProv" type="{http://www.w3.org/2001/XMLSchema}string"/>
                 *         &lt;element name="PostalCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
                 *         &lt;element name="Country" type="{http://www.w3.org/2001/XMLSchema}string"/>
                 *         &lt;element name="AddrType" type="{http://www.w3.org/2001/XMLSchema}string"/>
                 *       &lt;/sequence>
                 *     &lt;/restriction>
                 *   &lt;/complexContent>
                 * &lt;/complexType>
                 * </pre>
                 * 
                 * 
                 */
                @XmlAccessorType(XmlAccessType.FIELD)
                @XmlType(name = "", propOrder = {
                    "addr1",
                    "addr2",
                    "addr3",
                    "city",
                    "stateProv",
                    "postalCode",
                    "country",
                    "addrType"
                })
                public static class PostAddr {

                    @XmlElement(name = "Addr1", required = true)
                    protected String addr1;
                    @XmlElement(name = "Addr2", required = true)
                    protected String addr2;
                    @XmlElement(name = "Addr3", required = true)
                    protected String addr3;
                    @XmlElement(name = "City", required = true)
                    protected String city;
                    @XmlElement(name = "StateProv", required = true)
                    protected String stateProv;
                    @XmlElement(name = "PostalCode", required = true)
                    protected String postalCode;
                    @XmlElement(name = "Country", required = true)
                    protected String country;
                    @XmlElement(name = "AddrType", required = true)
                    protected String addrType;

                    /**
                     * Gets the value of the addr1 property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getAddr1() {
                        return addr1;
                    }

                    /**
                     * Sets the value of the addr1 property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setAddr1(String value) {
                        this.addr1 = value;
                    }

                    /**
                     * Gets the value of the addr2 property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getAddr2() {
                        return addr2;
                    }

                    /**
                     * Sets the value of the addr2 property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setAddr2(String value) {
                        this.addr2 = value;
                    }

                    /**
                     * Gets the value of the addr3 property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getAddr3() {
                        return addr3;
                    }

                    /**
                     * Sets the value of the addr3 property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setAddr3(String value) {
                        this.addr3 = value;
                    }

                    /**
                     * Gets the value of the city property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getCity() {
                        return city;
                    }

                    /**
                     * Sets the value of the city property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setCity(String value) {
                        this.city = value;
                    }

                    /**
                     * Gets the value of the stateProv property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getStateProv() {
                        return stateProv;
                    }

                    /**
                     * Sets the value of the stateProv property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setStateProv(String value) {
                        this.stateProv = value;
                    }

                    /**
                     * Gets the value of the postalCode property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getPostalCode() {
                        return postalCode;
                    }

                    /**
                     * Sets the value of the postalCode property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setPostalCode(String value) {
                        this.postalCode = value;
                    }

                    /**
                     * Gets the value of the country property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getCountry() {
                        return country;
                    }

                    /**
                     * Sets the value of the country property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setCountry(String value) {
                        this.country = value;
                    }

                    /**
                     * Gets the value of the addrType property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getAddrType() {
                        return addrType;
                    }

                    /**
                     * Sets the value of the addrType property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setAddrType(String value) {
                        this.addrType = value;
                    }

                }

            }

        }

    }

}
