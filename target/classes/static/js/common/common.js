function resetData(data, defaultData) {
    for (let key in data) {
        if (data.hasOwnProperty(key)) {
            data[key] = defaultData[key];
        }
    }
}