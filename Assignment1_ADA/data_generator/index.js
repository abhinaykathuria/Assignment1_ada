var fs = require('fs');
var randomstring = require('randomstring');
var deepcopy = require('deepcopy');
var randomChar = require('random-char');

var arraySize = 1000;
var searchSize=100;


var intArray = [];
for (var i = 0; i < arraySize; i++) {
	intArray.push(Math.round(Math.random() * Math.floor(1000)));
}

var intDataSet = [];
for (var i = 0; i < arraySize; i++) {
	intDataSet.push('A ' + intArray[i]);
}

var sortedIntArray = deepcopy(intArray).sort(sortNumber);
var sortedIntDataSet = [];
for (var i = 0; i < arraySize; i++) {
	sortedIntDataSet.push('A ' + sortedIntArray[i]);
}

var reversedIntArray = deepcopy(sortedIntArray).reverse();
var reversedIntDataSet = [];
for (var i = 0; i < arraySize; i++) {
	reversedIntDataSet.push('A ' + reversedIntArray[i]);
}
for (var i = 0; i < searchSize; i++) {
	reversedIntDataSet.push('S ' + reversedIntArray[i]);
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
for (var i = 0; i < searchSize; i++) {
	charDataSet.push('S ' + randomChar('alpha'));
}
var sortedStringDataSet = deepcopy(stringDataSet).sort();
var reversedStringDataSet = deepcopy(sortedStringDataSet).reverse();

var sortedCharDataSet = deepcopy(charDataSet).sort();
var reversedCharDataSet = deepcopy(sortedCharDataSet).reverse();

writeArrayToFile('TestData/Int/intDataSet.in', intDataSet);
writeArrayToFile('TestData/Int/sortedIntDataSet.in', sortedIntDataSet);
writeArrayToFile('TestData/Int/reversedIntDataSet.in', reversedIntDataSet);

writeArrayToFile('TestData/String/stringDataSet.in', stringDataSet);
writeArrayToFile('TestData/String/sortedStringDataSet.in', sortedStringDataSet);
writeArrayToFile('TestData//StringreversedStringDataSet.in', reversedStringDataSet);

writeArrayToFile('TestData/Char/charDataSet.in', charDataSet);
writeArrayToFile('TestData/Char/sortedCharDataSet.in', sortedCharDataSet);
writeArrayToFile('TestData/Char/reversedCharDataSet.in', reversedCharDataSet);

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
