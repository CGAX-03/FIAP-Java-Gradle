
			<html>
				<script>
					function fDownload(){
						document.frmDownload.submit();
					}
				</script>
				<body onload="javascript: fDownload();">
					<form name="frmDownload" target="_blank" method="get" action="/Controle404/download.php">
						<input type="hidden" name="file" value="upload_fiap/alunos/trabalhoGraduacao/arquivosAnexo/scripts_tb_marca.sql">
						<!--<input type="hidden" name="origem" value="asp">-->
					</form>
				</body>
			</html>
		