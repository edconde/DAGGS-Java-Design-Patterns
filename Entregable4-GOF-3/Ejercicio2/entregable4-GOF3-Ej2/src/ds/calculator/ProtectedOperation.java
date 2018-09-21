package ds.calculator;

import java.util.List;

import ds.miniframework.Operation;

public class ProtectedOperation extends Operation {

	private LicenseManager lm = new LicenseManager();
	private Operation protectedOperation;
	
	public ProtectedOperation(Operation protectedOp) {
		this.protectedOperation = protectedOp;
	}
	
	@Override
	public String _execute(List<String> params) {
		if(lm.checkIsFullVersion()) {
			return this.protectedOperation.execute(params);
		}else {
			return "Necesitas la versión PRO de CUTRECALC para"
					+ " usar la funcionalidad " + this.getName();
		}
	}

	@Override
	public String getName() {
		return this.protectedOperation.getName();
	}

	@Override
	public List<String> getParameters() {
		return this.protectedOperation.getParameters();
	}

	
}
