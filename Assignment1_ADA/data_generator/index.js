var fs = require('fs');
var randomstring = require('randomstring');
var deepcopy = require('deepcopy');
var randomChar = require('random-char');

var arraySize = 1000;
var searchSize = 10000;

var searchArray = [];
var intArray = [];
for (var i = 0; i < arraySize; i++) {
	intArray.push(Math.round(Math.random() * Math.floor(1000)));
}
 for (var i = 0; i < searchSize; i++) {
 	searchArray.push(Math.round(Math.random() * Math.floor(1000)));
 }
var intDataSet = [];
for (var i = 0; i < arraySize; i++) {
	intDataSet.push('A ' + intArray[i]);
}
 for (var i = 0; i < searchSize; i++) {
 	intDataSet.push('RO ' + searchArray[i]);
 }
var sortedIntArray = deepcopy(intArray).sort(sortNumber);
var sortedSearchArray = deepcopy(searchArray).sort(sortNumber);

var sortedIntDataSet = [];
for (var i = 0; i < arraySize; i++) {
	sortedIntDataSet.push('A ' + sortedIntArray[i]);
}
 for (var i = 0; i < searchSize; i++) {
 	sortedIntDataSet.push('RO ' + sortedSearchArray[i]);
 }

var reversedIntArray = deepcopy(sortedIntArray).reverse();
var reversedSearchArray = deepcopy(sortedSearchArray).reverse();

var reversedIntDataSet = [];
for (var i = 0; i < arraySize; i++) {
	reversedIntDataSet.push('A ' + reversedIntArray[i]);
}
 for (var i = 0; i < searchSize; i++) {
 	reversedIntDataSet.push('RO ' + reversedSearchArray[i]);
 }

var stringDataSet = [];
for (var i = 0; i <= arraySize; i++) {
	stringDataSet.push(
		'A ' +
			randomstring.generate({
				length: 3,
				charset: 'alphabetic',
				capitalization: 'lowercase'
			})
	);
}

var charDataSet = [];
for (var i = 0; i < arraySize; i++) {
	charDataSet.push('A ' + randomChar('alpha'));
}

var sortedStringDataSet = deepcopy(stringDataSet).sort();
var reversedStringDataSet = deepcopy(sortedStringDataSet).reverse();

var sortedCharDataSet = deepcopy(charDataSet).sort();
var reversedCharDataSet = deepcopy(sortedCharDataSet).reverse();

writeArrayToFile('TestData/Final_DataSet/Search/Small_Int Data/DataSet1.in', intDataSet);
writeArrayToFile('TestData/Final_DataSet/Search/Small_Int Data/sortedDataSet.in', sortedIntDataSet);
writeArrayToFile('TestData/Final_DataSet/Search/Small_Int Data/reversedSortedDataSet.in', reversedIntDataSet);

// writeArrayToFile('TestData/stringDataSet.in', stringDataSet);
// writeArrayToFile('TestData/sortedStringDataSet.in', sortedStringDataSet);
// writeArrayToFile('TestData/reversedStringDataSet.in', reversedStringDataSet);

// writeArrayToFile('TestData/charDataSet.in', charDataSet);
// writeArrayToFile('TestData/sortedCharDataSet.in', sortedCharDataSet);
// writeArrayToFile('TestData/reversedCharDataSet.in', reversedCharDataSet);

function getRandomInt(max) {
	return Math.floor(Math.random() * Math.floor(max));
}

function writeArrayToFile(filename, array) {
	var stream = fs.createWriteStream(filename, { flags: 'a' });
	array.forEach(function(item, index) {
		stream.write(item.valueOf().toString() + '\n');
	});
	stream.end();
}

function sortNumber(a, b) {
	return a - b;
}

function generateString() {
	var text = '';
	var possible = 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz';

	for (var i = 0; i < 5; i++)
		text += possible.charAt(Math.floor(Math.random() * possible.length));

	return text;
}
