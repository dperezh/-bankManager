package org.softdevelop.demo.banking.ws;


import org.softdevelop.demo.banking.dto.BranchOfficeRequest;
import org.softdevelop.demo.banking.dto.BranchOfficeResponse;

import javax.jws.WebService;
import javax.xml.bind.annotation.XmlElement;

@WebService(name = "SucursalesService")
public interface ISucursalesWS {

    BranchOfficeResponse getBranchOfficebyBankName(@XmlElement(required = true) BranchOfficeRequest branchRequest);
}
