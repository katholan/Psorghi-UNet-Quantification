#@ RoiManager RoiManager
#@ ResultsTable ResultsTable
import ij.IJ
path_to_output = '~/testing_leaves/'
ResultsTable.deleteRows(0, 999999)
annotations = RoiManager.getROIs()
annotations.each{ key, value ->
	ResultsTable.incrementCounter()
	p = value.getPolygon()
	ResultsTable.addValue("x", p.xpoints.join(",") + "," + p.xpoints[0])
	ResultsTable.addValue("y", p.ypoints.join(",") + "," + p.ypoints[0])}
img_filename = IJ.getImage().toString()
base_filename = img_filename.substring(5, img_filename.indexOf('.tif'))
//ResultsTable.show(base_filename)
ResultsTable.save(path_to_output + base_filename + '.csv')
