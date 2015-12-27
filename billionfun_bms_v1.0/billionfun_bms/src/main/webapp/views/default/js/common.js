/**
 * 
 */
function getSucDialog(suctxt){
	var suc_dia_html = "<div class=\"alert alert-block alert-success\">";
	suc_dia_html = suc_dia_html + "<p><strong><i class=\"icon-ok\"></i>"+suctxt+"</strong></p><div>";
	return suc_dia_html;
}
function getErrDialog(errtxt){
	var err_dia_html = "<div class=\"alert alert-danger\">";
	err_dia_html = err_dia_html + "<p><strong><i class=\"icon-remove\"></i>"+errtxt+"</strong></p><div>";
	return err_dia_html;
}