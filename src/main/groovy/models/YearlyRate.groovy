package models

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement

   /*
    * TODO: NOTHING! YOU DO NOT NEED TO MODIFY THIS FILE
    */

@JacksonXmlRootElement(localName = "rate")
class YearlyRate {

    Integer year

    Number largeCap
    Number midCap
    Number smallCap
    Number dowJones
    Number govtBonds
    Number corpBonds
    Number tBills

    void setYear(Double year) {
        this.year = year.intValue()
    }

}
