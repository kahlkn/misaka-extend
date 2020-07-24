package misaka.device;

import artoria.data.Device;
import artoria.data.RecombineUtils;
import artoria.file.Csv;
import artoria.util.Assert;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class FileBasedDeviceProvider implements DeviceProvider {
    private Map<String, Device> deviceMap;

    public FileBasedDeviceProvider(Csv csv) {
        List<Device> deviceList = csv.toBeanList(Device.class);
        Map<String, Device> modelMap = RecombineUtils.listToMapBean(deviceList, "model");
        deviceMap = Collections.unmodifiableMap(modelMap);
    }

    @Override
    public Device findByDeviceModel(String deviceModel) {
        Assert.notBlank(deviceModel, "Parameter \"deviceModel\" must not blank. ");
        return deviceMap.get(deviceModel);
    }

}
